import "io";

CPP {
    string test = "Hello, World!";
}

empty funct HelloWorld(str msg) {
    print(msg + " " + test + "\n");
};

HelloWorld("haha yes");