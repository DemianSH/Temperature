package temperature;

import search.BinarySearch;
import search.KindOfSearch;
import search.Search;
import sort.KindOfSort;
import sort.QuickSort;
import sort.Sort;

public abstract class TemperatureServiceFactory implements TemperatureService{

    protected Sort sort;
    protected Search search;

    public TemperatureServiceFactory(KindOfSort kindOfSort, KindOfSearch kindOfSearch) {
        this.sort = defineSort(kindOfSort);
        this.search = defineSearch(kindOfSearch);
    }

    private Sort defineSort(KindOfSort kindOfSort) {
        switch (kindOfSort) {
            case QUICK_SORT:
                return new QuickSort();
            default:
                System.out.println("unavailable kind of Sort");
                return null;
        }
    }

    private Search defineSearch(KindOfSearch kindOfSearch) {
        switch (kindOfSearch) {
            case BINARY_SEARCH:
                return new BinarySearch();
            default:
                System.out.println("unavailable kind of Search");
                return null;
        }
    }
}
