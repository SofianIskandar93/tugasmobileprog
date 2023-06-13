package com.project.budgetingapps;

import java.util.List;

public class parent2 {

    // Declaration of the variables
    private String ParentItemTitle;
    private List<childitem2> namapengeluaran;
    private List<childitem2> jumlah;
    private List<childitem2> tanggal;
    private String paren;
    // Constructor of the class
    // to initialize the variables
    public parent2(
            String ParentItemTitle,
            List<childitem2> ChildItemList,
            List<childitem2> listjumlah,
            List<childitem2> listtanggal,
            String namaparent)
    {

        this.ParentItemTitle = ParentItemTitle;
        this.namapengeluaran = ChildItemList;
        this.tanggal = listtanggal;
        this.jumlah = listjumlah;
        this.paren = namaparent;
    }

    // Getter and Setter methods
    // for each parameter
    public String getParentItemTitle()
    {
        return ParentItemTitle;
    }

    public void setParentItemTitle(
            String parentItemTitle)
    {
        ParentItemTitle = parentItemTitle;
    }

    public List<childitem2> getChildItemList()
    {
        return namapengeluaran;
    }
    public List<childitem2> getChildItemList2()
    {
        return jumlah;
    }
    public List<childitem2> getTanggal()
    {
        return tanggal;
    }
    public String getParent()
    {
        return paren;
    }

    public void setChildItemList(
            List<childitem2> childItemList)
    {
        namapengeluaran = childItemList;
    }
}
