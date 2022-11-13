package ViewModel;

public class DongVat {

    private String maDV;
    private String tenDv;
    private int canNang;
    private boolean gioiTinh;
    private int namSinh;

    public DongVat() {
    }

    public DongVat(String maDV, String tenDv, int canNang, boolean gioiTinh, int namSinh) {
        this.maDV = maDV;
        this.tenDv = tenDv;
        this.canNang = canNang;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDv() {
        return tenDv;
    }

    public void setTenDv(String tenDv) {
        this.tenDv = tenDv;
    }

    public int getCanNang() {
        return canNang;
    }

    public void setCanNang(int canNang) {
        this.canNang = canNang;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String trangThai() {
        if (this.getNamSinh() >= 2005) {
            return "Sinh lâu rồi";
        } else {
            return "Mới sinh";
        }
    }
}
