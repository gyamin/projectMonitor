#!/bin/bash
execDir=$(cd $(dirname $0); pwd)    # webapp/bin
source ${execDir}/_common.sh

# compile typescript files
if [ "${1}" = "watch" ]; then
#    ${baseDir}/node_modules/watch/cli.js "${baseDir}/node_modules/babel-cli/bin/babel.js ${jsSrcDir} --out-dir ${jsOutDir}"
    ${baseDir}/node_modules/watch/cli.js "${baseDir}/node_modules/babel-cli/bin/babel.js ${jsSrcDir} --out-file ${jsOutDir}/app.js"
else
#    ${baseDir}/node_modules/babel-cli/bin/babel.js ${jsSrcDir} --out-dir ${jsOutDir}
    ${baseDir}/node_modules/babel-cli/bin/babel.js ${jsSrcDir} --out-file ${jsOutDir}/app.js
fi
