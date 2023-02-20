fun main() {

    //val operator = Operator("MTS",7,100.0)
    //val payment = PaymentOperator("MTS",7,100.0,true)
    val operatorsList = mutableListOf<Operator>()
    while (true) {
        println("Введите что хотите сделать:")
        println("1-Ввод новых данных\n2-Поиск данных\n3-Вывод всех данных\n4-Фильтрация данных по различным полям\n5-Удаление данных\n0-Выйти из программы\n")
        when (readln().toInt()) {
            1 -> {
                println("Введите оператора, цену в минуту и площадь покрытия(каждое значение отдельным enter'ом):")
                val operatorName = readln()
                val price = readln().toDouble()
                val area = readln().toDouble()
                operatorsList.add(Operator(operatorName, price, area))
                println( operatorsList.size)
            }

            2 -> {
                println("Введите что ищем:")
                println("1-по названию оператора\n2-по стоимости в минуту\n3-по площади покрытия")
                val findIndex = readln().toInt()
                var i = 0
                println("Введите значение которое необходимо найти:")
                val answerFind = readln()
                val countList = mutableListOf<String>()
                while (i < operatorsList.size) {
                    when (findIndex) {
                        1 -> {
                            if (operatorsList[i].operatorName == answerFind)
                                    countList.add("${operatorsList[i].operatorName},${operatorsList[i].priceOneMinute},${operatorsList[i].coverageArea}")
                        }

                        2 -> {
                            if (operatorsList[i].priceOneMinute == answerFind.toDouble())
                                    countList.add("${operatorsList[i].operatorName},${operatorsList[i].priceOneMinute},${operatorsList[i].coverageArea}")
                        }

                        3 -> {
                            if (operatorsList[i].coverageArea == answerFind.toDouble())
                                    countList.add("${operatorsList[i].operatorName},${operatorsList[i].priceOneMinute},${operatorsList[i].coverageArea}")
                        }

                        else -> {
                            println("Введено не верное значение!")
                            break
                        }
                    }
                    i++
                }
                if (countList.size == 0)
                    println("Значение не найдено")
                else
                    for (i in 0..countList.size - 1)
                        println(countList[i])

            }

            3 -> {
                for (i in 0 until operatorsList.size)
                    println("${operatorsList[i].operatorName},${operatorsList[i].priceOneMinute},${operatorsList[i].coverageArea}")
            }

            4 -> {
                println("Введите по какому параметру фильтровать:")
                println("1-по цене\n2-по площади\n")
                val index = readln().toInt()
                println("Введите параметр по которому необходимо отфильтровать(1-больше чем,2 - меньше чем):")
                val filterUser = readln().toInt()
                println("Введите параметр по которому необходимо отфильтровать")
                val sortUser = readln()
                when (index) {

                    1 -> {
                        when (filterUser) {
                            1 -> {
                                val filterList = operatorsList.filter { it.priceOneMinute > sortUser.toDouble() }
                                if(filterList.size!=0)
                                    for (i in filterList.indices)
                                        println("${filterList[i].operatorName}, ${filterList[i].priceOneMinute},${filterList[i].coverageArea}")
                                else
                                    println("Не найдено значений")
                            }

                            2 -> {
                                val filterList = operatorsList.filter { it.priceOneMinute < sortUser.toDouble() }
                                if(filterList.size!=0)
                                    for (i in filterList.indices)
                                        println("${filterList[i].operatorName}, ${filterList[i].priceOneMinute},${filterList[i].coverageArea}")
                                else
                                    println("Не найдено значений")
                            }
                        }
                    }

                    2 -> {
                        when (filterUser) {
                            1 -> {
                                val filterList = operatorsList.filter { it.coverageArea > sortUser.toDouble() }
                                if(filterList.size!=0)
                                    for (i in filterList.indices)
                                        println("${filterList[i].operatorName}, ${filterList[i].priceOneMinute},${filterList[i].coverageArea}")
                                else
                                    println("Не найдено значений")
                            }

                            2 -> {
                                val filterList = operatorsList.filter { it.coverageArea < sortUser.toDouble() }
                                if(filterList.size!=0)
                                    for (i in filterList.indices)
                                        println("${filterList[i].operatorName}, ${filterList[i].priceOneMinute},${filterList[i].coverageArea}")
                                else
                                    println("Не найдено значений")
                            }

                            else -> {
                                println("Введено не верное значение!")
                                break
                            }
                        }


                    }
                }

            }

            5 -> {

                println("Введите индекс элемента который вы хотите удалить(доступно ${operatorsList.size}):")
                val indexUser = readln().toInt() - 1
                if (indexUser < operatorsList.size && indexUser!=-1) {
                    operatorsList.removeAt(indexUser)
                    println("Элемент ${indexUser + 1} успешно удалён!")
                } else
                    println("введён неверный индекс!")

            }

            0 -> break
            else -> println()


        }
    }
}