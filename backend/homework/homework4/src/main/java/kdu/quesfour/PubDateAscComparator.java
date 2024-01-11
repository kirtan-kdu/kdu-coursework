package kdu.quesfour;

import java.util.Comparator;

class PubDateAscComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return (((Book)o1).getYear() == ((Book)o2).getYear())?(((Book)o1).getTitle().compareTo(((Book)o2).getTitle())): (((Book)o1).getYear() - ((Book)o2).getYear());
    }
}

