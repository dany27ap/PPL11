import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File

fun main() = runBlocking <Unit>{
    Log.instance
    launch {
        Log.instance.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam fermentum consectetur dolor, non scelerisque ante varius vitae. Aliquam elementum faucibus odio, sed mattis est elementum in. Aenean sapien tortor, commodo ut augue quis, mollis tincidunt tellus. Ut ipsum enim, sagittis et eros consectetur, malesuada rhoncus velit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Praesent at dolor vitae tortor interdum venenatis. Curabitur varius, odio sed pretium eleifend, magna arcu commodo dolor, at tincidunt orci lorem nec massa. Aenean ex purus, venenatis non lorem vel, pulvinar congue ligula. Pellentesque ligula velit, dictum sit amet congue sed, malesuada nec nulla.\n" +
                "\n")
    }
    launch {
        Log.instance.write("Proin varius tincidunt ipsum, et aliquam enim suscipit in. Nam scelerisque eget enim et vulputate. Nulla viverra sagittis diam, non viverra arcu vulputate sed. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque tempus mi sed tellus faucibus, et viverra urna dictum. Vivamus sed arcu nec ligula semper consequat et ut mauris. Nullam rhoncus sodales lectus, sit amet fringilla urna lacinia id. Integer mollis tempor pretium. Nam iaculis neque non orci ornare, et lacinia lorem bibendum. Vivamus posuere sagittis neque. Nam tellus tellus, eleifend nec libero vel, rutrum imperdiet est. Phasellus vestibulum lectus mattis elit blandit rhoncus. Aliquam erat volutpat. Nulla orci dui, ullamcorper in nibh ut, ullamcorper ultricies dui. Donec lorem sem, hendrerit varius nunc eget, volutpat rhoncus nunc.\n")
    }
    launch {
        Log.instance.write("Vestibulum in leo a magna sodales consequat luctus quis ante. Praesent vitae hendrerit elit. Proin hendrerit vitae nunc nec ultricies. Aliquam luctus tellus non enim pretium, a porttitor dui condimentum. Nunc consectetur lorem eu eros tristique, in pulvinar tellus aliquam. Donec sapien felis, bibendum ac euismod et, molestie vel justo. Cras mattis diam vel dictum imperdiet. Nulla laoreet porttitor dui elementum sodales. Nulla aliquet elit ut arcu elementum, at tristique tellus interdum. Donec elementum eros in velit facilisis, id posuere metus elementum. In ut erat et nunc maximus pharetra in id dolor. Donec varius tristique ex vel viverra. Vestibulum non tincidunt massa, in iaculis eros.")
    }

}

class Log private constructor() {

    private val semafor : Semafor = Semafor()


    companion object {
        val  instance = Log()
        val fname = "Semafor"
    }

    fun write(line : String) {
        semafor.enter()
        File(fname).appendText(line)
        semafor.exit()
    }

    fun reset() {
        semafor.enter()
        File(fname).delete()
        semafor.exit()
    }
}

class Semafor {

    private var entered : Boolean = false

    fun enter() {
        while (entered){
            Thread.sleep(1)
        }
        entered = true
    }

    fun exit() {
        entered = false
    }
}