package com.gyamin.pjmonitor.batch.dataseeder.csvreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gyamin.pjmonitor.entity.TrnWorked;
import com.gyamin.pjmonitor.config.AppConfig;
import com.gyamin.pjmonitor.common.AppLogging;

/**
 *  first-d-j.csvを読み込み、銘柄オブジェクト配列を作成し、リターンする
 * @author Yasumasa
 */
public class SagyouJikanShukei implements CsvReaderInterface {
  // データソースCSVファイル
  private final String fileName = "SagyouJikanShukei.csv";

  /**
   *  first-d-j.csvを読み込み、銘柄オブジェクト配列を作成し、リターンする
   */
  @Override
  public ArrayList<Object> getImportBeansFromFile() {
    FileReader file = null;
    try {
      Properties appProperties = AppConfig.getApplicationProperties();
      file = new FileReader(System.getProperty("user.dir") + "/env/database/seeds/csv/" + fileName);
      BufferedReader br = new BufferedReader(file);
      String line;
      ArrayList<TrnWorked>trnWorkeds = new ArrayList<>();
      while((line = br.readLine()) != null) {
        // ,区切りで文字列を配列に格納
        String[] cols = line.split(",");
        TrnWorked trnWorked = new TrnWorked();
        // TrnWorkedオブジェクトにCSV値を設定
        trnWorked.setJobNo(cols[1]);
        trnWorked.setWorkDate(cols[11]);


        issue.section = "東証1部";
        issue.issue_code = Integer.parseInt(cols[1]);
        issue.issue_name = cols[2];
        issue.sector_code33 = Integer.parseInt(cols[3]);
        issue.sector_code17 = Integer.parseInt(cols[5]);
        issue.size_code = cols[7];
        issues.add(issue);
      }
      return issues;
      
    } catch (FileNotFoundException ex) {
      String msg = this.fileName + " が存在しません。";
      Logger.getLogger(AppLogging.LOG_NAME).log(Level.SEVERE, msg , ex);
    } catch (IOException ex) {
      Logger.getLogger(AppLogging.LOG_NAME).log(Level.SEVERE, null , ex);
    } finally {
      try {
        file.close();
      } catch (IOException ex) {
        Logger.getLogger(AppLogging.LOG_NAME).log(Level.SEVERE, null , ex);
      }
    }
    return null;
  }
}
