public class IndexDurationPair implements Comparable<IndexDurationPair>{
    private int _id;
    private int _duration;

    public IndexDurationPair(int id, int duration){
        _id = id;
        _duration = duration;
    }

    public int GetId(){
        return _id;
    }

    public int GetDuration(){
        return _duration;
    }

    @Override
    public int compareTo(IndexDurationPair idp) {
        if(_duration > idp._duration)
            return 1;
        else if(_duration == idp._duration)
            return 0;
        else return -1;
    }
}