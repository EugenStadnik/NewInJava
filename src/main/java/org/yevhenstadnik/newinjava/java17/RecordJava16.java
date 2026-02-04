package org.yevhenstadnik.newinjava.java17;

public record RecordJava16(String name, int idNo)
    // extends Record implicitly
    // extends OtherClass provides a compilation error
    implements NameId // Is possible to implement interfaces
    // implicitly final. Other classes cannon extend it
{

    static String defaultName = "Default Name"; // Static fields are allowed

    // String customField = "Custom Field"; // Compilation error: Instance fields are NOT allowed

    public RecordJava16(String name, int idNo) { // Canonical constructor
        if (name == null || name.isBlank() || idNo == 0) {
            throw new IllegalArgumentException("Invalid name or idNo");
        }
        this.name = name;
        this.idNo = idNo;
    }

    public RecordJava16(int id) { // Non-canonical constructor
        this(defaultName, id); // Delegating to the canonical constructor is required
    }

//  public RecordJava16 {} // Compact constructor: is similar to the custom one, but without parameters list. Only one constructor is allowed

    public String name() { return name; } // Overloaded accessor method for 'name' component

//  int idNo() { return idNo; } // Compilation error: accessor methods must be public

//  public Integer idNo() { return idNo; } // Compilation error: accessor methods must return the exact type of the component

//  public int idNo() throws NullPointerException { return idNo; } // Compilation error: accessor methods cannot have a throws clause

//  public <T> int idNo() { return idNo; } // Compilation error: accessor methods cannot have generic types

//  public static int idNo() { return idNo; } // Compilation error: accessor methods cannot be static

    public String getName() { return name; } // Custom getters can be defined

    public String getModifiedName() { return name.toUpperCase(); } // Another custom method

//   public void setName(String name) { this.name = name; } // Custom setters can be defined, but records are intended to be immutable

//   public RecordJava16(String name, int idNo) throws NullPointerException { // Compilation error: throws clause is not allowed
//        this.name = name;
//        this.idNo = idNo;
//    }

//   public <T> RecordJava16(String name, int idNo) { // Compilation error: Generic types are not supported
//        this.name = name;
//        this.idNo = idNo;
//    }

//   protected RecordJava16(String name, int idNo) { // Compilation error: the constructor is of more permitted level
//        this.name = name;
//        this.idNo = idNo;
//    }

//    public RecordJava16(String name, Integer idNo) { // Compilation error: parameter's type is different
//        this.name = name;
//        this.idNo = idNo;
//    }

//    public RecordJava16(String name, int justIdNo) { // Compilation error: parameter's name is different
//        this.name = name;
//        this.idNo = justIdNo;
//    }

//    public RecordJava16(String name) { this.name = name; } // Compilation error: a parameter list is different
//    and body contains NO "this" reference to canonical constructor

}

interface NameId {
    String name();
    int idNo();
}

class RecordDerived /* extends RecordJava16 */ {
    // Will produce compilation failure because records are implicitly final
}

record RecordGeneric<T>(T value) {
    // Records can be generic
}
