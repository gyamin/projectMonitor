package com.gyamin.pjmonitor.batch.dataseeder.csvreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gyamin.pjmonitor.entity.TrnWorked;
import com.gyamin.pjmonitor.config.AppConfig;

/**
 *  SagyouJikanShukei.csvを読み込み、作業実績データをオブジェクト化しリターンする
 * @author gyamin
 */
public class SagyouJikanShukei {
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SagyouJikanShukei.class.getName());

    // データソースCSVファイル
    private final String fileName = "SagyouJikanShukei.csv";

    /**
     *  SagyouJikanShukei.csvを読み込み、銘柄オブジェクト配列を作成し、リターンする
     */
    public ArrayList<TrnWorked> getImportBeansFromFile() {
        FileReader file = null;
        try {
            Properties appProperties = AppConfig.getApplicationProperties();
            file = new FileReader(System.getProperty("user.dir") + "/env/database/seeds/csv/" + fileName);
            BufferedReader br = new BufferedReader(file);
            String line;
            ArrayList<TrnWorked> trnWorkedList = new ArrayList<>();
            while((line = br.readLine()) != null) {
                // ,区切りで文字列を配列に格納
                String[] cols = line.split(",");
                TrnWorked trnWorked = new TrnWorked();
                // TrnWorkedオブジェクトにCSV値を設定
                trnWorked.setJobNo(cols[1]);
                trnWorked.setWorkDate(LocalDate.parse(cols[11]));

                trnWorkedList.add(trnWorked);
            }
            return trnWorkedList;

        } catch (FileNotFoundException ex) {
            String msg = this.fileName + " が存在しません。";
            log.error(msg + ex.toString());

        } catch (IOException ex) {
            log.error(ex.toString());
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                log.error(ex.toString());
            }
        }
        return null;
    }
}
