/// <reference path="./../common/config.ts"/>
var Common;
(function (Common) {
    // Log level list
    (function (LogLevel) {
        LogLevel[LogLevel["debug"] = 0] = "debug";
        LogLevel[LogLevel["info"] = 1] = "info";
        LogLevel[LogLevel["warning"] = 2] = "warning";
        LogLevel[LogLevel["error"] = 3] = "error";
    })(Common.LogLevel || (Common.LogLevel = {}));
    var LogLevel = Common.LogLevel;
    var Logger = (function () {
        function Logger() {
        }
        Logger.prototype.debug = function (message) {
            var logLevel = Common.Config.LOG_LEVEL;
            if (logLevel >= LogLevel.debug) {
                console.log(message);
            }
        };
        Logger.prototype.info = function (message) {
            var logLevel = Common.Config.LOG_LEVEL;
            if (logLevel >= LogLevel.info) {
                console.log(message);
            }
        };
        Logger.prototype.warning = function (message) {
            var logLevel = Common.Config.LOG_LEVEL;
            if (logLevel >= LogLevel.warning) {
                console.log(message);
            }
        };
        Logger.prototype.error = function (message) {
            var logLevel = Common.Config.LOG_LEVEL;
            if (logLevel >= LogLevel.error) {
                console.log(message);
            }
        };
        return Logger;
    }());
    Common.Logger = Logger;
})(Common || (Common = {}));
//# sourceMappingURL=logger.js.map