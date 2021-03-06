package sg.edu.tp.musicstream;
//Given
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//Include yourself
import android.content.Intent;
import android.util.Log;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    SongCollection songCollection = new SongCollection();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendDataToActivity(int index){
        Intent intent = new Intent(this, PlaySongActivity.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }
    public void handleSelection(View myView) {
        String resourceId = getResources().getResourceEntryName(myView.getId());
        Log.d("temasek", "The index in the array for this song is :" + resourceId);
        int currentArrayIndex = songCollection.searchSongById(resourceId);
        Log.d("temasek", "The index in the array for this song is :" + currentArrayIndex);
        sendDataToActivity(currentArrayIndex);
    }
}