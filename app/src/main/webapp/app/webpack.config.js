module.exports = {
  entry: {
    mst_projects: './src/js/mst_projects/index.js'
  },
  output: {
    path: __dirname + '/dist/js',
    filename: "[name].bundle.js",
  },
  devtool: 'source-map',
  module: {
    loaders: [
      { test: /\.css$/, loader: "style!css" },
      {
        test: /\.sass$/,
        loaders: ["style", "css", "sass"]
      },
      {
        test: /\.js?$/,
        exclude: /(node_modules|dist)/,
        loader: 'babel-loader',
        query: {
          cacheDirectory: true
        }
      }
    ]
  }
};


