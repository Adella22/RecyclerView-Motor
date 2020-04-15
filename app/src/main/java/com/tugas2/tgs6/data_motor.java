package com.tugas2.tgs6;

import java.util.ArrayList;

public class data_motor {
        private static String[] motorname = {
                "beat",
                "vario",
                "scoopy",
                "PCX",

        };
        private static String[] motorDetail = {
                "Beat(harga motor beat sangat terjangkau yaitu sekitar kurang lebih 12-14jt)";
                "Vario(Salah satu faktor yang menyebabkan motor Honda VARIO 150 eSP laris adalah karena harganya yang terjangkau, Honda VARIO 150 eSP dibanderol Rp 20.900.000,- sangat murah bukan untuk motor dengan teknologi eSP.)";
                "Scoopy (Hadirnya Scoopy memberikan warna baru dalam dunia motor matic di tanah air sehingga segmen pasar motor matic menjadi semakin luas.)";
                "PCX(PCX ini jadi motor yang nanggung, baik sebagai kendaraan harian atau cruiser touring antar kota. Dari sisi kelincahan memang mendukung untuk membelah kemacetan di kota besar. Sayangnya, akselerasi All New Honda PCX cukup lambat dan tenaga yang mudah ngedrop membuat pengendara perlu memainkan gas.)"

        private static int[] motorImages = {
                R.drawable.beat,
                R.drawable.vario,
                R.drawable.scoopy,
                R.drawable.PCX,

        };

        static ArrayList<motor> getListData() {
            ArrayList<motor> list = new ArrayList<>();
            for (int position = 0; position < motorname.length; position++) {
                motor motor = new motor();
                motor.setName(motorname[position]);
                motor.setDetail(motorDetail[position]);
                motor.setPhoto(motorImages[position]);
                list.add(motor);
            }
            return list;
        }
    }
}

