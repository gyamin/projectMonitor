package com.gyamin.pjmonitor.batch.dataseeder;

import com.gyamin.pjmonitor.batch.dataseeder.loader.TrnWorkedBuilder;
import org.apache.log4j.Logger;

/**
 * データ作成処理実行クラス
 * @author gyamin
 */
public class ExecuteDataSeed {
    static Logger log = Logger.getLogger(ExecuteDataSeed.class);

    /**
    * データベースへのデータ登録処理実行クラス
    * @param args コマンドパラメータ
    */
    public static void main(String[] args) {
        log.info("CSV読み込み処理開始");
        // 処理開始
        // trnWorkedテーブルにデータを登録
        TrnWorkedBuilder trnWorkedBuilder = new TrnWorkedBuilder();
        trnWorkedBuilder.buildUpData();
    }
}
