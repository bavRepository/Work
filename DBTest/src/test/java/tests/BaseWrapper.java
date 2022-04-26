package tests;

import model.Author;
import model.Project;
import utils.Config;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseWrapper {

    protected DateFormat df = new SimpleDateFormat(Config.DATE_MASK);
    protected Date dateBeforeTest;
    protected Author author;
    protected Project project;
}
