/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

import java.util.List;

/**
 *
 * @author cagdas
 */
public class Data {
    private String title;
    private Long id;
    private Boolean children;
    private List<Data> groups;

    public String getTitle() { return title; }
    public Long getId() { return id; }
    public Boolean getChildren() { return children; }
    public List<Data> getGroups() { return groups; }

    public void setTitle(String title) { this.title = title; }
    public void setId(Long id) { this.id = id; }
    public void setChildren(Boolean children) { this.children = children; }
    public void setGroups(List<Data> groups) { this.groups = groups; }

    public String toString() {
        return String.format("title:%s,id:%d,children:%s,groups:%s", title, id, children, groups);
}
    }