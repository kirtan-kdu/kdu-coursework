package kdu.quesfour;

import java.util.Comparator;

public class PubDateDecComparator implements Comparator {
        @Override
        public int compare(Object o2, Object o1) {
            return (((Book)o1).getYear() == ((Book)o2).getYear())?(((Book)o1).getTitle().compareTo(((Book)o2).getTitle())): (((Book)o1).getYear() - ((Book)o2).getYear());
        }


    }
