import kotlin.random.Random

fun main(){
    var player = Player()
    player.playing();
}

class Dice(
    var num: Int = 0,
    var loc: Boolean = false
    ){
    fun rolling(): Int {
        if (!this.loc)
            this.num = (1..6).random()
            return this.num
    }
    fun locked() {
        this.loc = true
    }
    fun getValue(): Int{
        return this.num
    }
    fun isLocked(): Boolean{
        return this.loc
    }
}

class Player(
    var d1: Dice =Dice(0),
    var d2: Dice =Dice(0),
    var d3: Dice =Dice(0),
    var d4: Dice =Dice(0),
    var d5: Dice =Dice(0),
    var d6: Dice =Dice(0),
) {
    val dices = arrayOf<Dice>(d1, d2, d3, d4, d5, d6)
    fun playing() {
        var br1 = 0
        var br2 = 0
        var br3 = 0
        var br4 = 0
        var br5 = 0
        var br6 = 0
        for (i in 1..3) {
            for (j in 0..dices.size - 1) {
                if (dices[j].isLocked()) println("  ${j + 1}. ${dices[j].rolling()}\tlocked") else println("  ${j + 1}. ${dices[j].rolling()}")
                if (dices[j].getValue() == 1) br1++
                else if (dices[j].getValue() == 2) br2++
                else if (dices[j].getValue() == 3) br3++
                else if (dices[j].getValue() == 4) br4++
                else if (dices[j].getValue() == 5) br5++
                else if (dices[j].getValue() == 6) br6++;
            }

            fun Poker(){
                if(br1 == 4){ println("POKER!") }
                if(br2 == 4){ println("POKER!") }
                if(br3 == 4){ println("POKER!") }
                if(br4 == 4){ println("POKER!") }
                if(br5 == 4){ println("POKER!") }
                if(br6 == 4){ println("POKER!") }
            }
            fun Yamb(){
                if(br1 == 5 || br1 == 6){ println("YAMB!") }
                if(br2 == 5 || br2 == 6){ println("YAMB!") }
                if(br3 == 5 || br3 == 6){ println("YAMB!") }
                if(br4 == 5 || br4 == 6){ println("YAMB!") }
                if(br5 == 5 || br5 == 6){ println("YAMB!") }
                if(br6 == 5 || br6 == 6){ println("YAMB!") }
            }

            fun Scale(){
                if(br1==1 && br2==1 && br3==1 && br4==1 && br5==1 && br6==1){
                    println("SCALE!")
                }
            }

            var check: String
            if (i != 3) {
                Poker()
                Yamb()
                Scale()
                println("Do you want to lock dices? (y/n)")
                check = readLine()!!
                if (check == "y") {
                    println("Type '0' for exit after you enter dices")
                    check  = readLine()!!
                    while (check != "0") {
                        if (check == "1") {
                            dices[0].locked()
                        } else if (check == "2") {
                            dices[1].locked()
                        } else if (check == "3") {
                            dices[2].locked()
                        } else if (check == "4") {
                            dices[3].locked()
                        } else if (check == "5") {
                            dices[4].locked()
                        } else if (check == "6") {
                            dices[5].locked()
                        }
                        check = readLine()!!
                    }
                }

            }
        }
    }
}



