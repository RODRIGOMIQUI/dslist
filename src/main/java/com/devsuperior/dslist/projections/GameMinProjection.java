package com.devsuperior.dslist.projections;

import java.util.List;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
    public List<GameMinProjection> searchByList(Long listId);
    
}
