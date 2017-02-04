class DateUtil {
  constructor(localDateTimeObj) {
    this.year = localDateTimeObj.year;
    this.monthValue = localDateTimeObj.monthValue;
    this.month = localDateTimeObj.month;
    this.dayOfYear = localDateTimeObj.dayOfYear;
    this.dayOfMonth = localDateTimeObj.dayOfMonth;
    this.dayOfWeek = localDateTimeObj.dayOfWeek;

    this.date = new Date(this.year, (this.monthValue -1), this.dayOfMonth );
    console.log(this.date);
  }

  getDateWithFormat(format = "") {
    let line = this.date.getFullYear() + "/" +
      this.date.getMonth() + "/" +
      this.date.getDay();
    return line;
  }
}

class DateTimeUtil extends DateUtil {
  constructor(localDateTimeObj) {
    super(localDateTimeObj);
    this.hour = localDateTimeObj.hour;
    this.minute = localDateTimeObj.minute;

    'second' in localDateTimeObj ? this.second = localDateTimeObj.second : this.second = 0;
    'nano' in localDateTimeObj ? this.nano = localDateTimeObj.nano : this.nano = 0;

    this.date = new Date(this.year, (this.monthValue -1), this.dayOfMonth , this.hour, this.minute, this.second);
    console.log(this.date);
  }

  getDateWithFormat(format = "") {
    let line = this.date.getFullYear() + "/" +
      this.date.getMonth() + "/" +
      this.date.getDay() + " " +
      this.date.getHours() + ":" +
      this.date.getMinutes();
    return line;
  }
}
