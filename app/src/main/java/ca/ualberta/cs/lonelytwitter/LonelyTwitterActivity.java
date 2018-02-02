package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by dezfuli on 1/16/18.
 */

/**
 * This is the main activity for the lonelyTwitter app. It runs the UI and saves and loads tweets.
 * It displays the tweets on the screen and shows a save and clear button at the buttom for saving
 * the tweets or deleting them.
 * @author dezfuli
 * @see Tweet
 * @see Activity
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "tweet_list.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	
	/**
	 * Activity for when the lonelyTwitter app is started. It sets the layout and view for the main
	 * activity. It also sets the onClickListener for the save button, this listener saves the tweet
	 * typed when clicked.
	 *
	 * @param savedInstanceState the state if the app was still running in the background
	 * */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("LifeCycle ---->", "onCreate is called");
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);
				adapter.notifyDataSetChanged();
				saveInFile();

			}
		});
	}

	/**
	 * Sets the adapter and saved tweets to the view so they are displayed.
	 */
	@Override
	protected void onStart() {

		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LifeCycle --->", "onStart is called");
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);

	}

	/**
	 * Loads the old tweets from their saved text file. Uses the saved string under FILENAME for
	 * the saved file's name. Uses GSON to save the files. This is called when loading in the app.
	 * @throws RuntimeException
	 *
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			System.out.println(listType);
			tweetList = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            tweetList = new ArrayList<Tweet>();
        } catch (IOException e) {
            throw new RuntimeException();
        }
	}

	/**
	 * Saves the tweets that are on the screen to a file using the
	 * FILENAME string. Uses GSON to save the file.
	 * @throws RuntimeException
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();

		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * This clears the tweets that are on the screen,
	 * this essentially empties the save file.
	 * This is called when the user presses the clear button on the IO.
	 * @param view the current view
	 */
	public void clear(View view){
        tweetList.clear();
        adapter.notifyDataSetChanged();
	}

	/**
	 * Deconstructs the application.
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Lifecycle", "onDestroy is called");
	}
}