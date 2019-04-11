package br.org.venturus.domain.common

interface Mapper<in E, T> {
    fun mapFrom(from: E): T
}