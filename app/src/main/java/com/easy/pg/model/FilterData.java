package com.easy.pg.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterData {

    private List<PGFilterInfo> pgFilterInfos = new ArrayList<>();

    public FilterData(List<PGFilterInfo> pgFilterInfos) {
        this.pgFilterInfos = pgFilterInfos;
    }

    public List<PGFilterInfo> getPgFilterInfos() {
        return pgFilterInfos;
    }

    public void setPgFilterInfos(List<PGFilterInfo> pgFilterInfos) {
        this.pgFilterInfos = pgFilterInfos;
    }

    public List<String> getUniquePGKeys() {
        List<String> pg = new ArrayList<>();
        for (PGFilterInfo filterInfo : pgFilterInfos) {
            if (!pg.contains(filterInfo.getPg())) {
                pg.add(filterInfo.getPg());
            }
        }
        Collections.sort(pg);
        return pg;
    }

    public List<String> getUniqueAreaKeys() {
        List<String> area = new ArrayList<>();
        for (PGFilterInfo filterInfo : pgFilterInfos) {
            if (!area.contains(filterInfo.getArea() + "")) {
                area.add(filterInfo.getArea() + "");
            }
        }
        Collections.sort(area);
        return area;
    }

    public List<String> getUniqueCollegeKeys() {
        List<String> colleges = new ArrayList<>();
        for (PGFilterInfo filterInfo : pgFilterInfos) {
            if (!colleges.contains(filterInfo.getCollege() + "")) {
                colleges.add(filterInfo.getCollege() + "");
            }
        }
        Collections.sort(colleges);
        return colleges;
    }

    public List<String> getUniqueDistanceKeys() {
        List<String> distance = new ArrayList<>();
        for (PGFilterInfo filterInfo : pgFilterInfos) {
            int dist = (int) Math.floor(filterInfo.getDistance());
            String distInKm = dist + " Km";
            if (!distance.contains(distInKm)) {
                distance.add(distInKm);
            }
        }
        Collections.sort(distance);
        return distance;
    }

    public List<String> getUniquePriceKeys() {
        List<String> price = new ArrayList<>();
        for (PGFilterInfo filterInfo : pgFilterInfos) {
            String rs = filterInfo.getPriceRangeStart() + " - " + filterInfo.getPriceRangeEnd() + "rs";
            if (!price.contains(rs)) {
                price.add(rs);
            }
        }
        Collections.sort(price);
        return price;
    }

    public List<String> getUniqueRatingKeys() {
        List<String> ratings = new ArrayList<>();
        for (PGFilterInfo filterInfo : pgFilterInfos) {
            int rating = (int) Math.floor(filterInfo.getRating());
            String rate = "> " + rating;
            if (!ratings.contains(rate)) {
                ratings.add(rate);
            }
        }
        Collections.sort(ratings);
        return ratings;
    }
    private static FilterData filterData;
    public static FilterData getSampleFilterData() {
        if(filterData == null) {
            List<PGFilterInfo> mList = new ArrayList<>();
            mList.add(new PGFilterInfo("Bhatia PG", "Janakpuri, Delhi","MSIT", 3, 0, 4000, 5.8f));
            mList.add(new PGFilterInfo("OYO PG", "Vasant Kunj, Delhi", "NSIT", 2, 0, 2000, 7.4f));
            mList.add(new PGFilterInfo("MMT PG", "Gaziabaad", "IMT", 1, 0, 5000, 7.4f));
            mList.add(new PGFilterInfo("Chawla PG", "Chandigadh", "PIT Chandigadh", 2, 0, 1000, 8.4f));
            mList.add(new PGFilterInfo("Kumar PG", "Delhi", "IIT Delhi", 5, 500, 3000, 7.6f));
            mList.add(new PGFilterInfo("Some PG", "Kanpur", "IIT Kanpur", 0.5f, 0, 2000, 5.4f));
            mList.add(new PGFilterInfo("Patil PG", "Mumbai", "IIT Mumbai", 1.5f, 1000, 7000, 8.4f));
            mList.add(new PGFilterInfo("Kumar PG", "Patna", "NIT", 2.0f, 0, 1500, 4.4f));
            mList.add(new PGFilterInfo("Huda PG", "Gurgaon", "MIT", 1, 0, 1000, 7.4f));
            mList.add(new PGFilterInfo("Arora PG", "Delhi", "DU", 8, 3000, 10000, 7.9f));
            mList.add(new PGFilterInfo("Patil PG", "Sangli", "RIT", 10, 500, 2500, 6.8f));
            mList.add(new PGFilterInfo("Anna PG", "Vellore", "VIT", 0.2f, 2000, 5000, 6.4f));
            mList.add(new PGFilterInfo("Anna PG", "Banglore", "IISC", 1, 0, 1000, 7.4f));
            mList.add(new PGFilterInfo("GND PG", "Patiala", "Thapar Institute", 4, 1500, 8000, 7.4f));
            mList.add(new PGFilterInfo("GND PG", "Amritsar", "Guru Nanak Dev University", 2.5f, 0, 2000, 5.4f));
            mList.add(new PGFilterInfo("Hindu PG", "Banaras", "BHU", 1, 0, 4000, 9.4f));

            filterData = new FilterData(mList);
        }
        return filterData;
    }
}
