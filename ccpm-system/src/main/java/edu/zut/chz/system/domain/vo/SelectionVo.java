package edu.zut.chz.system.domain.vo;

public class SelectionVo {
    private Long userId;
    private Long libraryId;

    @Override
    public String toString() {
        return "SelectionVo{" +
                "userId=" + userId +
                ", libraryId=" + libraryId +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }
}
