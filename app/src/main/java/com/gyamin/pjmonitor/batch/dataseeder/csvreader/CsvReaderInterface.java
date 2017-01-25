package com.gyamin.pjmonitor.batch.dataseeder.csvreader;

import java.util.ArrayList;

/**
 * csv読み込みクラスインターフェイス
 * @author Yasumasa
 */
public interface CsvReaderInterface {
  public ArrayList<Object> getBeansFromFile();
}
