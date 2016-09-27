package com.example.cheryl.timetable;

public class periods {

    private int day;

    private static String[] head={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    private static String[][] period={{"Comp Org","Comp Org","Unix","DMS","DS","Maths 3","EC/LD lab","EC/LD lab","EC/LD lab"},
            {"Ec/Ld","Ec/Ld","DMS","DS","Unix","Maths 3","Tutorials","Tutorials","Tutorials"},
            {"DMS","DS","Maths 3","DS Lab","DS Lab","DS Lab"," --- "," --- "," --- "},
            {"Unix","Unix","Comp Org","Ec/Ld","DMS","DS"," --- "," --- "," --- "},
            {"DMS","Maths 3","Unix"," --- "," --- "," --- "," --- "," --- "," --- "},
            {"Comp Org","Comp Org","DS","Ec/Ld","Ec/Ld","Maths 3"," --- "," --- "," --- "}};

    public void setDay(String s){
        day = getDayInt(s);
    }

    public String getDay(){
        return getDayString(day);
    }

    public String[] getPeriods(){
        return period[day];
    }

    public void next(){
        day=(day+1)%6;
    }

    public void previous(){
        day=(day-1);
        if(day == -1)day=5;
    }

    private int getDayInt(String d){

        switch (d){
            case "Monday":return 0;
            case "Tuesday":return 1;
            case "Wednesday":return 2;
            case "Thursday":return 3;
            case "Friday":return 4;
            case "Saturday":return 5;
            case "Sunday":return 0;
            default:return 0;
        }

    }

    private String getDayString(int d){
        switch (d){
            case 0:return "Monday";
            case 1:return "Tuesday";
            case 2:return "Wednesday";
            case 3:return "Thursday";
            case 4:return "Friday";
            case 5:return "Saturday";
            default: return "default";
        }
    }

}
