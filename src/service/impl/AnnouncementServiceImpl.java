package service.impl;

import dao.AnnouncementDao;
import models.Announcement;
import service.AnnouncementService;

import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService {

    private AnnouncementDao announcementDao;

    public AnnouncementServiceImpl(AnnouncementDao announcementDao) {
        this.announcementDao = announcementDao;
    }
    @Override
    public String addAnnouncement(Announcement announcement) {
        return announcementDao.addAnnouncement(announcement);
    }

    @Override
    public List<Announcement> getAllAnnouncement() {
        return announcementDao.getAllAnnouncement();
    }

    @Override
    public List<Announcement> getAnnouncementByAnnouncementID(long ID) {
        return announcementDao.getAnnouncementByAnnouncementID(ID);
    }

    @Override
    public String getUpdateAnnouncement(long ID, Announcement announcement) {
        return announcementDao.getUpdateAnnouncement(ID, announcement);
    }

    @Override
    public String getDeleteAnnouncement(Long ID) {
        return announcementDao.getDeleteAnnouncement(ID);
    }
}
