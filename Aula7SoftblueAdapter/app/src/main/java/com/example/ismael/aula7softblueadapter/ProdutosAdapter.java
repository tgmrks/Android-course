package com.example.ismael.aula7softblueadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ismael on 13/07/15.
 */
public class ProdutosAdapter extends BaseAdapter {

    private List<Produto> produtos;
    private LayoutInflater inflater;

    public ProdutosAdapter(Context context, List<Produto> produtos) {
        this.produtos = produtos;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //getView MELHORADO, PARA MELHOR PERFORMANCE
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder vh;

        if (view == null) {

            view = inflater.inflate(R.layout.adapter_produto, parent, false);
            vh = new ViewHolder();
            vh.txtNome = (TextView) view.findViewById(R.id.txt_produto);
            vh.txtPreco = (TextView) view.findViewById(R.id.txt_preco);
            view.setTag(vh);
        }
        else {
            vh = (ViewHolder) view.getTag();
        }


        Produto produto = produtos.get(position);

        vh.txtNome.setText(produto.getNome());
        double db = produto.getPreco();
        vh.txtPreco.setText(Double.valueOf(db).toString());

        return view;
    }

    private static class ViewHolder {
        public TextView txtNome;
        public TextView txtPreco;
    }

    //************APLICAÇÃO SIMPLES DE getView() ...SEM APRIMORAMENTO DE PERFORMANCE ^^^^^^^^^^
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        //View que deve ser mostrada na tela <coloca o item_custom dentro da list>
//        View view = inflater.inflate(R.layout.adapter_produto, parent,false);
//        Produto produto = produtos.get(position);
//
//        TextView txtNome = (TextView) view.findViewById(R.id.txt_produto);
//        TextView txtPreco = (TextView) view.findViewById(R.id.txt_preco);
//
//        txtNome.setText(produto.getNome());
//
//        double db = produto.getPreco();
//        txtPreco.setText(Double.valueOf(db).toString());
//
//        return view;
//    }
}
