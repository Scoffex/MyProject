const path = require('path');
const HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {
    entry: path.resolve(__dirname, './src/index.js'),
    mode: 'development',
    output: {
        filename: '[name].js',
        path: path.resolve(__dirname, 'dist')
    },
    devtool: 'inline-source-map',
    watchOptions: {
        ignored: /node_modules/,
    },

    devServer: {
        static: {
            directory: path.join(__dirname, './dist'),
        },
        port: 4300,
        open: {
            app: {
                name: 'chrome',
                arguments: ['--new-window', '--auto-open-devtools-for-tabs']
            }
        }
    },

    plugins: [
        new HtmlWebpackPlugin({
            title: "Formazione ITS",
            meta: {
                viewport: 'width=device-width, initial-scale=1.0'
            },
            scriptLoading: "defer"
        }),
    ]
};
