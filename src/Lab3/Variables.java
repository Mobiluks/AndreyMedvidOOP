package Lab3;

import java.util.*;
import java.io.*;

public class Variables implements Serializable{
    private static final long serialVersionUID = 1L;
    List<String>  source;
    public Variables(){

    }
    public Variables(List<String> source) {
        this.source = source;
    }
}
