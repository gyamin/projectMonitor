package com.gyamin.pjmonitor.batch.dataseeder.loader;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.batch.dataseeder.csvreader.Member;
import com.gyamin.pjmonitor.batch.dataseeder.csvreader.SagyouJikanShukei;
import com.gyamin.pjmonitor.dao.MstWorkersDao;
import com.gyamin.pjmonitor.dao.MstWorkersDaoImpl;
import com.gyamin.pjmonitor.dao.TrnWorkedDao;
import com.gyamin.pjmonitor.dao.TrnWorkedDaoImpl;
import com.gyamin.pjmonitor.entity.MstWorkers;
import com.gyamin.pjmonitor.entity.TrnWorked;
import org.seasar.doma.jdbc.tx.TransactionManager;

import java.util.ArrayList;

/**
 * issuesテーブルにcsvからマスタを設定する
 * @author Yasumasa
 */
public class MstWorkersBuilder extends AbstractBuilder {

    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MstWorkersBuilder.class.getName());

    // 取り込みデータ配列
    private ArrayList<MstWorkers> mstWorkersArrayList = new ArrayList<>();

    /**
     * CSVファイルからデータを読み込み、データ配列を準備する
     */
    @Override
    void prepareImportBeansFromFile() {
        //
        Member member = new Member();
        this.mstWorkersArrayList = member.getImportBeansFromFile(true);
    }

    /**
     * データ配列からテーブルにデータを登録する
     */
    @Override
    public void buildUpData() {
        log.info(MstWorkersBuilder.class.getName() + "データ登録処理開始");
        this.prepareImportBeansFromFile();
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        MstWorkersDao mstWorkersDao = new MstWorkersDaoImpl();

        tm.required(() -> {
            for (MstWorkers mstWorkers : this.mstWorkersArrayList) {
                mstWorkersDao.insert(mstWorkers);
            }
        });
    }
}
