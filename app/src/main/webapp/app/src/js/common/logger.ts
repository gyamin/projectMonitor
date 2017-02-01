namespace Common {

    // Log level list
    export enum LogLevel {
        debug,
        info,
        warning,
        error
    }

    export class Logger {
        private logLevel = LogLevel.debug;

        debug(message: string) :void {
            if(this.logLevel >= LogLevel.debug) {
                console.log(message);
            }
        }

        info(message: string) :void {
            if(this.logLevel >= LogLevel.info) {
                console.log(message);
            }
        }

        warning(message: string) :void {
            if(this.logLevel >= LogLevel.warning) {
                console.log(message);
            }
        }

        error(message: string) :void {
            if(this.logLevel >= LogLevel.error) {
                console.log(message);
            }
        }
    }
}
