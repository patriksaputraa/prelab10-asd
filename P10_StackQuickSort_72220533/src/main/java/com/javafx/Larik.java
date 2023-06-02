package com.javafx;

public class Larik {
    private int[] data;
    private int cacah;

    public Larik(int byk) {
        this.data = new int[byk];
        this.cacah = 0;
    }

    public void add(int bil) {
        if (this.cacah < this.data.length)
            this.data[cacah++] = bil;
        else
            System.out.println("Array sudah penuh!");
    }

    public String getArray() {
        String s = "";
        for (int idx = 0; idx < this.cacah; idx++)
            s += this.data[idx] + ", ";
        s = s.substring(0, s.length() - 2);
        return s;
    }

    public String quickSort() {
        Stack2 t = new Stack2(20);
        String result = "Array Awal : " + getArray() + "\n";
        int i, j, pivot, sementara;
        t.push(0, this.cacah - 1);
        while (!t.habis()) {
            Batas bts = t.pop(); //batas array
            i = bts.getKiri();
            j = bts.getKanan();
            result += "Stack : \n ["+i+","+j+"]\n";
            pivot = bts.getKiri();
            result += "Batas kiri: " + bts.getKiri() + ", Batas kanan: " + bts.getKanan() + ", Pivot: " + pivot + "\n";
            while (i < j) {
                while (data[j] >= data[pivot] && j > pivot){
                    j--; //bergerak dari getKanan() ke getKiri()
                }
                result += "j:" + j + ", Pivot:" + pivot + " <-tukar-> " + j + ", array: " + getArray() +  "\n";
                sementara = data[pivot];
                data[pivot] = data[j];
                data[j] = sementara;
                pivot = j; // Pivot pindah ke j
                while (data[i] < data[pivot] && i < pivot){
                    i++; // bergerak dari getKiri() ke getKanan()
                }
                result += "i:" + i + ", Pivot:" + pivot + " <-tukar-> " + i + ", array: " + getArray() +  "\n\n";
                sementara = data[pivot];
                data[pivot] = data[i];
                data[i] = sementara;
                pivot = i; // Pivot pindah ke i
            }
            if (bts.getKiri() < pivot - 1){ // jika di getKiri() Pivot minimal ada 2 elemen
                t.push(bts.getKiri(), pivot - 1);
            }
            if (bts.getKanan() > pivot + 1){ // jika di getKanan() Pivot minimal ada 2 elemen
                t.push(pivot + 1, bts.getKanan());
            }
        }
        return result;
    }
}
