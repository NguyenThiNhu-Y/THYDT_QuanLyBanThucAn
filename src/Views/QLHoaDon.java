/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.CTHD;
import Models.HDonn;
import Models.KHHang;
import Models.SanPham;
import Services.ServiceCTHDd;
import Services.ServiceHoaDo;
import Services.ServiceKH;
import Services.UserServices;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84327
 */
public class QLHoaDon extends javax.swing.JFrame {
    DefaultTableModel defaultTableModel, tableModel;
    ServiceHoaDo serviceHoaDon;
    ServiceCTHDd serviceCTHD;
    ServiceKH serviceKH;
    UserServices serviceSP;
    /**
     * Creates new form QLHoaDon
     */
    public void setTableHD(List<HDonn> list){
        for (HDonn hDon : list) {
            defaultTableModel.addRow(new Object[]{hDon.getIdHD(),hDon.getIdKH(),hDon.getNgayTao(), hDon.getIdBan(),hDon.getIdVC()});
        }
    }
    public void setTableCTHD(List<CTHD> list){
        for (CTHD cthd : list) {
            String id = cthd.getIdSP();
            String tenSP="", kichCo="";
            for (SanPham sp : serviceSP.getAllSP()) {
                if(id == null ? sp.getId()== null : id.equals(sp.getId()))
                {
                    tenSP = sp.getTen();
                    kichCo = sp.getDinhLuong();
                }
            }
            tableModel.addRow(new Object[]{tenSP,kichCo,cthd.getSoLuong(),cthd.getDonGia()});
        }
    }
    public QLHoaDon() {
        initComponents();
        serviceSP = new UserServices();
        serviceHoaDon = new ServiceHoaDo();
        defaultTableModel = new DefaultTableModel(){
            @Override //để người dùng không thể thay đổi dữ liêu thêm vào isCellEdittable
            public boolean isCellEditable(int row, int column) {
                //return super.isCellEditable(row, column); 
                return false;
            }
        };
        tbHoaDon.setModel(defaultTableModel);
        defaultTableModel.addColumn("IdHD");
        defaultTableModel.addColumn("idKH");
        defaultTableModel.addColumn("ngayTao");
        defaultTableModel.addColumn("Ban");
        defaultTableModel.addColumn("Voucher");
        setTableHD(serviceHoaDon.getAllHoaDon());
        
        pnChiTiet.setVisible(false);
        
        tableModel = new DefaultTableModel(){
            @Override //để người dùng không thể thay đổi dữ liêu thêm vào isCellEdittable
            public boolean isCellEditable(int row, int column) {
                //return super.isCellEditable(row, column); 
                return false;
            }
        };
        tbSanPham.setModel(tableModel);
        tableModel.addColumn("tên sản phẩm");
        tableModel.addColumn("kích cỡ");
        tableModel.addColumn("số lượng");
        tableModel.addColumn("đơn giá");
        
        
        lbCBaoHD.setVisible(false);
        lbCBaoKH.setVisible(false);
        lbCBaoNgay.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btChiTiet = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbTongTiien = new javax.swing.JLabel();
        lbIdHD = new javax.swing.JTextField();
        lbIdKH = new javax.swing.JTextField();
        btTim = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbHD = new javax.swing.JCheckBox();
        cbKH = new javax.swing.JCheckBox();
        cbNgay = new javax.swing.JCheckBox();
        lbCBaoHD = new javax.swing.JLabel();
        lbCBaoKH = new javax.swing.JLabel();
        lbCBaoNgay = new javax.swing.JLabel();
        lbNgay = new com.toedter.calendar.JDateChooser();
        pnChiTiet = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lbTenKH = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbLoaiKH = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        navTrangChu = new javax.swing.JPanel();
        btnTrangChu = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();
        btnBan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 390, 820, 190);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn  "));

        jLabel2.setText("ID hóa đơn");

        jLabel3.setText("ID Khách hàng");

        jLabel5.setText("Ngày tạo");

        btChiTiet.setText("Xem chi tiết");
        btChiTiet.setEnabled(false);
        btChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChiTietActionPerformed(evt);
            }
        });

        jLabel8.setText("Tổng tiền");

        lbTongTiien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btTim.setText("Tìm");
        btTim.setEnabled(false);
        btTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tiêu chí tìm kiếm"));

        cbHD.setText("ID Hóa đơn");
        cbHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHDActionPerformed(evt);
            }
        });

        cbKH.setText("ID Khách hàng");
        cbKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKHActionPerformed(evt);
            }
        });

        cbNgay.setText("Ngày tạo");
        cbNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNgayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cbHD, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(cbKH)
                .addGap(18, 18, 18)
                .addComponent(cbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHD)
                    .addComponent(cbKH)
                    .addComponent(cbNgay))
                .addContainerGap())
        );

        lbCBaoHD.setForeground(new java.awt.Color(255, 0, 0));
        lbCBaoHD.setText("*");

        lbCBaoKH.setForeground(new java.awt.Color(255, 0, 0));
        lbCBaoKH.setText("*");

        lbCBaoNgay.setForeground(new java.awt.Color(255, 0, 0));
        lbCBaoNgay.setText("*");

        lbNgay.setDateFormatString("d/M/y");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(btChiTiet)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbIdHD))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbTongTiien, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbIdKH)
                                    .addComponent(lbNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbCBaoNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbCBaoKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbCBaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbIdHD)
                        .addComponent(lbCBaoHD))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbIdKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbCBaoKH)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(lbCBaoNgay)
                    .addComponent(lbNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTongTiien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btTim)
                    .addComponent(btChiTiet))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 70, 380, 310);

        pnChiTiet.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hóa đơn    "));

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbSanPham);

        jLabel6.setText("Tên khách hàng");

        lbTenKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Loại khách hàng");

        lbLoaiKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnChiTietLayout = new javax.swing.GroupLayout(pnChiTiet);
        pnChiTiet.setLayout(pnChiTietLayout);
        pnChiTietLayout.setHorizontalGroup(
            pnChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChiTietLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnChiTietLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChiTietLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnChiTietLayout.setVerticalGroup(
            pnChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel1.add(pnChiTiet);
        pnChiTiet.setBounds(420, 80, 430, 290);

        jPanel4.setBackground(new java.awt.Color(102, 204, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        navTrangChu.setBackground(new java.awt.Color(102, 204, 255));
        navTrangChu.setPreferredSize(new java.awt.Dimension(100, 40));
        navTrangChu.setLayout(new java.awt.GridLayout(1, 0));

        btnTrangChu.setBackground(new java.awt.Color(102, 204, 255));
        btnTrangChu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        btnTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTrangChu.setText("Trang chủ");
        btnTrangChu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseMoved(evt);
            }
        });
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseExited(evt);
            }
        });
        navTrangChu.add(btnTrangChu);

        btnBack.setBackground(new java.awt.Color(102, 204, 255));
        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBack.setText("/");
        btnBack.setOpaque(true);

        btnBan.setBackground(new java.awt.Color(102, 204, 255));
        btnBan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBan.setForeground(new java.awt.Color(255, 255, 255));
        btnBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBan.setText("Quản lí hóa đơn");
        btnBan.setMinimumSize(new java.awt.Dimension(20, 40));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(navTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addGap(5, 5, 5)
                .addComponent(btnBan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(582, 582, 582))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnBan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 0, 880, 45);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        serviceCTHD = new ServiceCTHDd();
        
        btChiTiet.setEnabled(true);
        pnChiTiet.setVisible(false);
        int row = tbHoaDon.getSelectedRow();
        String idHD = (String) tbHoaDon.getValueAt(row, 0);
        String idKH = (String) tbHoaDon.getValueAt(row, 1);
        Date ngayTao =  (Date) tbHoaDon.getValueAt(row, 2);
        lbIdHD.setText(idHD);
        lbIdKH.setText(idKH);
//        try {
//            Date date1 = new SimpleDateFormat("d/M/y").parse(ngayTao);
//            lbNgay.setDate(date1);
//        } catch (ParseException ex) {
//           // Logger.getLogger(ThongKeSP.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        lbNgay.setDate(ngayTao);
        
        
        lbTongTiien.setText(""+serviceCTHD.tienHD(idHD));
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimActionPerformed
        if(!cbHD.isSelected()&&!cbKH.isSelected()&&!cbNgay.isSelected())
        {
            defaultTableModel.setRowCount(0);
            setTableHD(serviceHoaDon.getAllHoaDon());
        }
        else
        {
            String idHD = lbIdHD.getText();
            String idKH = lbIdKH.getText();
            //Date ngay = lbNgay.getDate();
            java.util.Date tkt =  lbNgay.getDate();
            java.sql.Date ngay=new java.sql.Date (tkt.getTime());
            //String ngay = lbNgay.getText();
            if(cbHD.isSelected())
                if("".equals(lbIdHD.getText()))
                {
                    JOptionPane.showMessageDialog(rootPane, "tiêu chí bạn chọn không được để trống");
                    lbCBaoHD.setVisible(true);
                }
                else
                    lbCBaoHD.setVisible(false);

            if(cbKH.isSelected())
                if("".equals(lbIdKH.getText()))
                {
                    JOptionPane.showMessageDialog(rootPane, "tiêu chí bạn chọn không được để trống");
                    lbCBaoKH.setVisible(true);
                }
                else
                    lbCBaoKH.setVisible(false);

            if(cbNgay.isSelected())
                if("".equals(ngay))
                {
                    JOptionPane.showMessageDialog(rootPane, "tiêu chí bạn chọn không được để trống");
                    lbCBaoNgay.setVisible(true);
                }
                else
                    lbCBaoNgay.setVisible(false);

            serviceHoaDon = new ServiceHoaDo();
            defaultTableModel.setRowCount(0);
            if(cbHD.isSelected() && !cbKH.isSelected() && !cbNgay.isSelected() )
                setTableHD(serviceHoaDon.timHD_idHD(idHD));


            if(!cbHD.isSelected() && cbKH.isSelected() && !cbNgay.isSelected() )
                setTableHD(serviceHoaDon.timHD_idKH(idKH));

            if(cbHD.isSelected() && cbKH.isSelected() && !cbNgay.isSelected() )
                setTableHD(serviceHoaDon.timHD_idKH_idKD(idKH,idHD));

            if(!cbHD.isSelected() && !cbKH.isSelected() && cbNgay.isSelected() )
                setTableHD(serviceHoaDon.timHD_ngay((java.sql.Date) ngay));

            if(!cbHD.isSelected() && cbKH.isSelected() && cbNgay.isSelected() )
                setTableHD(serviceHoaDon.timHD_idKH_ngay(idKH, (java.sql.Date) ngay));

            if(cbHD.isSelected() && cbKH.isSelected() && cbNgay.isSelected() )
                setTableHD(serviceHoaDon.timHD(idKH, (java.sql.Date) ngay,idHD));
        }
        
    }//GEN-LAST:event_btTimActionPerformed

    private void btChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChiTietActionPerformed
        pnChiTiet.setVisible(true);
        lbTenKH.setText("");
        lbLoaiKH.setText("");
        tableModel.setRowCount(0);
        String idHD = lbIdHD.getText();
        serviceCTHD = new ServiceCTHDd();
        setTableCTHD(serviceCTHD.getCTHD(idHD));

        String idKH = lbIdKH.getText();
        String tenKH="", loaiKH="";
        serviceKH = new ServiceKH();
        for (KHHang object : serviceKH.getKh()) {
            if(idKH == null ? object.getIdKH() == null : idKH.equals(object.getIdKH()))
            {
                tenKH = object.getTenKH();
                loaiKH = object.getLoaiKH();
            }
        }
        lbTenKH.setText(tenKH);
        lbLoaiKH.setText(loaiKH);
    }//GEN-LAST:event_btChiTietActionPerformed

    private void cbHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHDActionPerformed
        if(cbHD.isSelected())
            btTim.setEnabled(true);
            
    }//GEN-LAST:event_cbHDActionPerformed

    private void cbKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKHActionPerformed
        if(cbKH.isSelected())
            btTim.setEnabled(true);
    }//GEN-LAST:event_cbKHActionPerformed

    private void cbNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNgayActionPerformed
        if(cbNgay.isSelected())
            btTim.setEnabled(true);
    }//GEN-LAST:event_cbNgayActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        int c = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn đóng không?");
//        if(c == JOptionPane.YES_OPTION)
//        {
//            
//            TrangChu tc = new TrangChu();
//            tc.setVisible(true);
//            tc.setLocationRelativeTo(null);
//            this.dispose();
//        }
    }//GEN-LAST:event_formWindowClosing

    private void btnTrangChuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseMoved
        btnTrangChu.setForeground(Color.decode("#66CCFF"));
        navTrangChu.setBackground(Color.white);
    }//GEN-LAST:event_btnTrangChuMouseMoved

    private void btnTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseClicked
        TrangChu tc = new TrangChu();
        tc.setVisible(true);
        tc.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnTrangChuMouseClicked

    private void btnTrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseExited
        btnTrangChu.setForeground(Color.white);
        navTrangChu.setBackground(Color.decode("#66CCFF"));
    }//GEN-LAST:event_btnTrangChuMouseExited

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                QLHoaDon qLHoaDon = new QLHoaDon();
//                qLHoaDon.setVisible(true);
//                qLHoaDon.setLocationRelativeTo(null);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChiTiet;
    private javax.swing.JButton btTim;
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnBan;
    private javax.swing.JLabel btnTrangChu;
    private javax.swing.JCheckBox cbHD;
    private javax.swing.JCheckBox cbKH;
    private javax.swing.JCheckBox cbNgay;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbCBaoHD;
    private javax.swing.JLabel lbCBaoKH;
    private javax.swing.JLabel lbCBaoNgay;
    private javax.swing.JTextField lbIdHD;
    private javax.swing.JTextField lbIdKH;
    private javax.swing.JLabel lbLoaiKH;
    private com.toedter.calendar.JDateChooser lbNgay;
    private javax.swing.JLabel lbTenKH;
    private javax.swing.JLabel lbTongTiien;
    private javax.swing.JPanel navTrangChu;
    private javax.swing.JPanel pnChiTiet;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbSanPham;
    // End of variables declaration//GEN-END:variables
}
