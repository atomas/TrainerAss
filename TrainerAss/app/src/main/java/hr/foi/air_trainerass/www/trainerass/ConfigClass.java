package hr.foi.air_trainerass.www.trainerass;

/**
 * Created by izavrski on 30.12.2015..
 */
public class ConfigClass {

    //Address of our scripts of the CRUD
    public static final String URL_ADD="http://izavrski.netau.net/dodajSportasa.php";
    public static final String URL_GET_ALL = "http://izavrski.netau.net/dohvatiSportase.php";
    // public static final String URL_GET_EMP = "http://192.168.94.1/Android/CRUD/getEmp.php?id=";
    // public static final String URL_UPDATE_EMP = "http://192.168.94.1/Android/CRUD/updateEmp.php";
    //public static final String URL_DELETE_EMP = "http://192.168.94.1/Android/CRUD/deleteEmp.php?id=";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAME = "name";
    public static final String KEY_EMP_DAT = "dat";
    public static final String KEY_EMP_TRENER = "trener";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_DAT = "dat";
    public static final String TAG_TRENER = "trener";

    //employee id to pass with intent
    // public static final String EMP_ID = "emp_id";


    //URL to our login.php file
    public static final String LOGIN_URL = "http://izavrski.netau.net/login.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "trainerassistant";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "email";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}