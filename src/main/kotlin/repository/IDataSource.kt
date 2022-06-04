package repository

import model.App

interface IDataSource {
    fun getAllData():List<App>?
}