package dao.impl;

import com.sun.source.tree.BreakTree;
import dao.AnnouncementDao;
import db.DataBase;
import models.Announcement;

import java.util.List;

public class AnnouncementDaoImpl implements AnnouncementDao {

    private DataBase dataBase;

    public AnnouncementDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String addAnnouncement(Announcement announcement) {
        dataBase.getAnnouncements().add(announcement);
        return "Added Announcement";
    }

    @Override
    public List<Announcement> getAllAnnouncement() {
        return dataBase.getAnnouncements();

    }

    @Override
    public List<Announcement> getAnnouncementByAnnouncementID(long ID) {
        for (Announcement announcement : dataBase.getAnnouncements()) {
            if (announcement.getId().equals(ID)) {
                dataBase.getAnnouncements().add(announcement);
                return dataBase.getAnnouncements();
            }
        }
        return dataBase.getAnnouncements();
    }

    @Override
    public String getUpdateAnnouncement(long ID, Announcement announcement) {
        for (Announcement announcement1 : dataBase.getAnnouncements()) {
            if (announcement1.getId().equals(ID)) {
                dataBase.getAnnouncements().add(announcement);
            }
        }
        return "Updated Announcement";
    }

    @Override
    public String getDeleteAnnouncement(Long ID) {
        for (Announcement announcement : dataBase.getAnnouncements()) {
            if (announcement.getId().equals(ID)) {
                dataBase.getAnnouncements().remove(announcement);
            }
        }
        return "Deleted Announcement";

    }

}