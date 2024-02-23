create database qlsach;
use qlsach;

ALTER DATABASE qlsach CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
create table sach (
	sach_id varchar(10) primary key,
    ten_sach varchar(20) not null,
    ma_tac_gia varchar(10) not null,
    ma_nxb varchar(10) not null,
    dau_sach varchar(10) not null
);
alter table sach add constraint fk_dau_sach foreign key (dau_sach) references the_loai(dau_sach);
alter table sach add constraint fk_ma_tac_gia foreign key (ma_tac_gia) references tac_gia(ma_tac_gia);
alter table sach add constraint fk_ma_nxb foreign key (ma_nxb) references nxb(ma_nxb);

create table the_loai (
	dau_sach varchar(10) primary key,
    ten_tl varchar(20)
);

create table tac_gia (
	ma_tac_gia varchar(10) primary key,
    ten_tg varchar(20)
);

create table nxb (
	ma_nxb varchar(10) primary key,
    ten_nxb varchar(20) not null,
    dia_chi varchar(50) not null
);


insert into the_loai value ('TL1', 'truyện ngắn');
insert into the_loai value ('TL2', 'truyện tranh');
insert into tac_gia value ('TG1', 'Nguyễn Nhật Ánh');
insert into tac_gia value ('TG2', 'Nam Cao');
insert into nxb value ('NXB1', 'NXB Kim Đồng', 'Số 55 Quang Trung, Nguyễn Du, Hai Bà Trưng, Hà Nội');
insert into nxb value ('NXB2', 'NXB Văn học', '18 Nguyễn Trường Tộ - Ba Đình - Hà Nội');
insert into sach value ('S1', 'Truyện ngắn Nam Cao','TG2','NXB2','TL1');

delimiter @
create procedure deleteBook (in sach_id varchar(10))
begin
	delete from sach where sach.sach_id = sach_id;
end@

create procedure insertBook ( in p_sach_id varchar(10),
    in p_ten_sach varchar(20),in p_ma_nxb varchar(10),
    in p_ma_tac_gia varchar(10),in p_dau_sach varchar(10)
)
begin
    insert into sach (sach_id, ten_sach, ma_tac_gia, ma_nxb, dau_sach)
    values (p_sach_id, p_ten_sach, p_ma_tac_gia, p_ma_nxb, p_dau_sach);
end@


create procedure updateBook (in p_sach_id varchar(10),
	in p_ten_sach varchar(20),in p_ma_tac_gia varchar(10),
	in p_ma_nxb varchar(10),in p_dau_sach varchar(10)
)
begin
    update sach
    set ten_sach = p_ten_sach,
        ma_tac_gia = p_ma_tac_gia,
        ma_nxb = p_ma_nxb,
        dau_sach = p_dau_sach
    where sach_id = p_sach_id;
end@

call updateBook("S2", "Truyện Ngắn Nam Cao", "TG2", "NXB1", "TL1")@

create procedure searchBooksByName(IN p_bookName varchar(20))
begin select * from sach where ten_sach like concat('%', p_bookName, '%'); end@

create procedure insertType ( in p_dau_sach varchar(10), in p_ten_tl varchar(20))
begin
	insert into the_loai(dau_sach, ten_tl)
    values  (p_dau_sach, p_ten_tl);
end@




