package org.pojo;

import java.util.Date;

public class JsApiTicket {
    String ticket;
    int expires_in;
    Date occurDate;

    public JsApiTicket(String ticket, int expires_in,Date occd) {
        this.ticket = ticket;
        this.expires_in = expires_in;
        this.occurDate = occd;
    }

    public String getTicket() {
        return ticket;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public Date getOccurDate() {
        return occurDate;
    }
    public  boolean isValid() {
          if (new Date().getTime() / 1000 - occurDate.getTime()/1000 > (expires_in-60*15))//”‡¡ø15∑÷÷”
              return false;
          else
              return true;
      }
}
