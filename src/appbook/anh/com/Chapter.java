package appbook.anh.com;


import com.example.bookapp.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import appbook.customelistview.com.MyarrayAdapter;
import appbook.customelistview.com.ViewData;

public class Chapter extends Activity{

	ListView lvnoidung;

	MyarrayAdapter adapter;

	private static String title[];
	private static String desc[];

	private static String noidunganh[];
	private static String noidungviet[];
	Integer[] imdid = {
			R.drawable.chuong1,
			R.drawable.chuong2,
			R.drawable.chuong3,
			R.drawable.chuong4,
			R.drawable.chuong5,
			R.drawable.chuong6,
			R.drawable.chuong7,
			R.drawable.chuong8,
			R.drawable.chuong9,
			R.drawable.chuong10
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chapter);


		Resources r = getResources();
		title =r.getStringArray(R.array.titleanh);
		desc =r.getStringArray(R.array.destribeanh);
		noidunganh =r.getStringArray(R.array.noidunganh);
		noidungviet =r.getStringArray(R.array.noidungviet);


		lvnoidung = (ListView) findViewById(R.id.lvnoidungsach);
		adapter = new MyarrayAdapter(this, imdid, title, desc);
		lvnoidung.setAdapter(adapter);
		registerForContextMenu(lvnoidung);

		lvnoidung.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent inten = new Intent(Chapter.this, ViewData.class);
				inten.putExtra("Data", noidunganh[arg2]);
				inten.putExtra("postion", arg2);
				startActivity(inten);
				

			}

		});


		


	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.bookmark:

		{

		}
		break;
		case R.id.english:

		{
		
			Resources r = getResources();
			title =r.getStringArray(R.array.titleanh);
			desc =r.getStringArray(R.array.destribeanh);

			lvnoidung = (ListView) findViewById(R.id.lvnoidungsach);
			adapter = new MyarrayAdapter(this,imdid, title, desc);
			lvnoidung.setAdapter(adapter);

			lvnoidung.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
					Intent inten = new Intent(Chapter.this, ViewData.class);
					inten.putExtra("Data", noidunganh[arg2]);
					inten.putExtra("postion", arg2);
					startActivity(inten);
				}

			});
		
		}

		break;
		case R.id.vietnamese:

		{
			Resources r = getResources();
			title =r.getStringArray(R.array.titleviet);
			desc =r.getStringArray(R.array.destribeviet);

			lvnoidung = (ListView) findViewById(R.id.lvnoidungsach);
			adapter = new MyarrayAdapter(this,imdid,  title, desc);
			lvnoidung.setAdapter(adapter);

			lvnoidung.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					
					
					Intent inten = new Intent(Chapter.this, ViewData.class);
					inten.putExtra("Data", noidungviet[arg2]);
					inten.putExtra("postion", arg2);
					startActivity(inten);
				}

			});
			
		}


		break;

		default:
			break;
		}
		return super.onContextItemSelected(item);
	}


	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		getMenuInflater().inflate(R.menu.listviewmenulongclick, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	


}
