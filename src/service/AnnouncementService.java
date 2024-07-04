package service;

import models.Announcement;

import java.util.List;

public interface AnnouncementService {
    String addAnnouncement(Announcement announcement);
    List<Announcement> getAllAnnouncement();
    List<Announcement> getAnnouncementByAnnouncementID(long ID);
    String getUpdateAnnouncement(long ID, Announcement announcement);
    String getDeleteAnnouncement(Long ID);
}
