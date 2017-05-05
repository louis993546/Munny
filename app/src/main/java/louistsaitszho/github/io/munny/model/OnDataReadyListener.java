package louistsaitszho.github.io.munny.model;

/**
 * A simple Listener to listen to when the data is ready
 * Created by Louis on 5/5/2017.
 */
public interface OnDataReadyListener<T>  {
    void callback(T results);
}