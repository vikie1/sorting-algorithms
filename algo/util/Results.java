package algo.util;

public class Results {
    private int n;
    private String sort;
    private long comparisons;
    private long movements;
    private long duration;

    public Results() {
    }

    /**
     * @return the duration
     */
    public long getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * @return the movements
     */
    public long getMovements() {
        return movements;
    }

    /**
     * @param movements the movements to set
     */
    public void setMovements(long movements) {
        this.movements = movements;
    }

    /**
     * @return the comparisons
     */
    public long getComparisons() {
        return comparisons;
    }

    /**
     * @param comparisons the comparisons to set
     */
    public void setComparisons(long comparisons) {
        this.comparisons = comparisons;
    }

    /**
     * @return the sort
     */
    public String getSort() {
        return sort;
    }

    /**
     * @param sort the sort to set
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * @param n
     * @param dataType
     * @param sort
     * @param comparisons
     * @param movements
     * @param duration
     */
    public Results(int n, String sort, long comparisons, long movements, long duration) {
        this.setN(n);
        this.setSort(sort);
        this.setComparisons(comparisons);
        this.setMovements(movements);
        this.setDuration(duration);
    }
    
}
