package com.gyamin.pjmonitor.batch.dataseeder.loader;

import java.util.ArrayList;
import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.batch.dataseeder.csvreader.SagyouJikanShukei;
import com.gyamin.pjmonitor.dao.TrnWorkedDao;
import com.gyamin.pjmonitor.dao.TrnWorkedDaoImpl;
import com.gyamin.pjmonitor.entity.TrnWorked;
import org.seasar.doma.jdbc.tx.TransactionManager;

import java.sql.SQLException;

/**
 * issuesテーブルにcsvからマスタを設定する
 * @author Yasumasa
 */
public class TrnWorkedBuilder extends AbstractBuilder {

    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TrnWorkedBuilder.class.getName());

    // 取り込みデータ配列
    private ArrayList<TrnWorked> trnWorkedList = new ArrayList<>();

    /**
     * CSVファイルからデータを読み込み、データ配列を準備する
     */
    @Override
    void prepareImportBeansFromFile() {
        //
        SagyouJikanShukei sagyouJikanShukei = new SagyouJikanShukei();
        this.trnWorkedList = sagyouJikanShukei.getImportBeansFromFile(true);
    }

    /**
     * データ配列からテーブルにデータを登録する
     */
    @Override
    public void buildUpData() {
        log.info(TrnWorkedBuilder.class.getName() + "データ登録処理開始");
        this.prepareImportBeansFromFile();
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        TrnWorkedDao trnWorkedDao = new TrnWorkedDaoImpl();

        tm.required(() -> {
            for (TrnWorked trnWorked : this.trnWorkedList) {
                trnWorkedDao.insert(trnWorked);
            }
        });
    }
}
