package ua.koval4uk;

import jnr.ffi.LibraryLoader;
import jnr.ffi.Pointer;

public class Main {

    public static final String LIB_NAME = "uapki";

    /**
     * Exception in thread "main" java.lang.UnsatisfiedLinkError: dlopen(/Users/arkovalchuk/Library/Java/Extensions/libuapkif.2.0.0.dylib, 9): Library not loaded: libuapkic.2.0.0.dylib
     *   Referenced from: /Users/arkovalchuk/Library/Java/Extensions/libuapkif.2.0.0.dylib
     *   Reason: image not found
     */
    public static void main(String[] args) {
        LibraryLoader<LibUapki> loader = LibraryLoader.create(LibUapki.class);
        loader.load("uapkic.2.0.0");
        loader.load("uapkif.2.0.0");
        loader.load("cm-pkcs12");
        LibUapki libUapki = loader.load(LIB_NAME);

        Pointer result = libUapki.process("{\"method\":\"VERSION\"}");
        String ret = result.getString(0);
        System.out.println("Result: " + ret);
    }

}
