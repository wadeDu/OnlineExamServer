package org.mislab.test.event;

import org.mislab.api.event.EventAction;
import org.mislab.api.event.EventType;
import org.mislab.api.event.OnlineExamEvent;

/**
 *
 * @author Max
 */
public class StudentAccount extends UserAccount {

    public StudentAccount(String n, String pw) {
        super(n, pw);
    }

    @Override
    public void setupEventListener() {
        evMgr.addEventListener(this, EventType.Exam, EventAction.Extend);
        evMgr.addEventListener(this, EventType.Exam, EventAction.Halt);
        evMgr.addEventListener(this, EventType.Exam, EventAction.Pause);
        evMgr.addEventListener(this, EventType.Exam, EventAction.Resume);
        evMgr.addEventListener(this, EventType.Exam, EventAction.Start);
        evMgr.addEventListener(this, EventType.Exam, EventAction.Stop);
        evMgr.addEventListener(this, EventType.Chat, EventAction.NewMessage);
        evMgr.addEventListener(this, EventType.Monitor, EventAction.RequestSnapshot);        
    }
    
    @Override
    public void handleOnlineExamEvent(OnlineExamEvent e) {
        String sname = (String) e.getContent().get("name");
        System.out.println(String.format("%s got an event %s from %s", name, e, sname));
    }
}
