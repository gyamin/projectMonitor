package com.gyamin.pjmonitor.batch.dataseeder.loader;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.batch.dataseeder.csvreader.Anken;
import com.gyamin.pjmonitor.dao.TrnProjectOrdersDao;
import com.gyamin.pjmonitor.dao.TrnProjectOrdersDaoImpl;
import com.gyamin.pjmonitor.entity.TrnProjectOrders;
import org.seasar.doma.jdbc.tx.TransactionManager;

import java.util.ArrayList;

/**
 * issuesテーブルにcsvからマスタを設定する
 * @author Yasumasa
 */
public class TrnProjectOrdersBuilder extends AbstractBuilder {

    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TrnProjectOrdersBuilder.class.getName());

    // 取り込みデータ配列
    private ArrayList<TrnProjectOrders> trnProjectOrdersArrayList = new ArrayList<>();

    /**
     * CSVファイルからデータを読み込み、データ配列を準備する
     */
    @Override
    void prepareImportBeansFromFile() {
        //
        Anken anken = new Anken();
        this.trnProjectOrdersArrayList = anken.getImportBeansFromFile(true);
    }

    /**
     * データ配列からテーブルにデータを登録する
     */
    @Override
    public void buildUpData() {
        log.info(TrnProjectOrdersBuilder.class.getName() + "データ登録処理開始");
        this.prepareImportBeansFromFile();
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        TrnProjectOrdersDao trnProjectOrdersDao = new TrnProjectOrdersDaoImpl();

        tm.required(() -> {
            for (TrnProjectOrders trnProjectOrders : this.trnProjectOrdersArrayList) {
                trnProjectOrdersDao.insert(trnProjectOrders);
            }
        });
    }
}
