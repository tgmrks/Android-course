package br.com.softblue.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    private DadosFragment dados1Fragment;
    private DadosFragment dados2Fragment;
    private DadosFragment dados3Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            dados1Fragment = new DadosFragment().setLayoutId(R.layout.dados1);
            dados2Fragment = new DadosFragment().setLayoutId(R.layout.dados2);
            dados3Fragment = new DadosFragment().setLayoutId(R.layout.dados3);

        } else {
            setContentView(R.layout.activity_main);

            ListView listView = (ListView) findViewById(R.id.list);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            adapter.add(getResources().getString(R.string.txt_dados1));
            adapter.add(getResources().getString(R.string.txt_dados2));
            adapter.add(getResources().getString(R.string.txt_dados3));
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return false;
        }

        getMenuInflater().inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            getFragmentManager().beginTransaction().replace(android.R.id.content, dados1Fragment, "dados1Fragment").commit();
            return true;
        } else if (item.getItemId() == R.id.item2) {
            getFragmentManager().beginTransaction().replace(android.R.id.content, dados2Fragment, "dados2Fragment").commit();
            return true;
        } else if (item.getItemId() == R.id.item3) {
            getFragmentManager().beginTransaction().replace(android.R.id.content, dados3Fragment, "dados3Fragment").commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = (String) parent.getAdapter().getItem(position);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }
}