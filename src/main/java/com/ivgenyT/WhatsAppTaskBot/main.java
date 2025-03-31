package com.ivgenyT.WhatsAppTaskBot;

import com.ivgenyT.WhatsAppTaskBot.MessageReceiver.MessageReceiver;
import com.ivgenyT.WhatsAppTaskBot.Bot.WhatsAppBot;
import com.ivgenyT.WhatsAppTaskBot.MessageSender.MessageSender;

public class main {

    public static void main(String[] args) {

        WhatsAppBot bot = new WhatsAppBot();
        bot.Init();
        MessageReceiver receiver = new MessageReceiver();
        MessageSender sender = new MessageSender();



        Thread botThread = new Thread(bot);
        Thread receiverThread = new Thread(receiver);
        Thread senderThread = new Thread(sender);



        botThread.start();
        receiverThread.start();
        senderThread.start();












        //String sendMess = " היי יבגני, אני הבוט האישי שיעזור לך לנהל את המשימות האישיות שלך! " +
               // "נוצרתי על ידי יבגני, מבקש לא לשלוח הודעות בחזרה מכיון שאני עדיין בתהליך פיתוח תודה ! :)";

        //init contacts
        //Contacts IRina = Contacts.IRINA;
        //Contacts Ella = Contacts.ELLA;
        //Contacts Pasha = Contacts.PASHA;
        // Contacts Leasha = Contacts.Alex;
        //String ivgenyPhoneNum = Contacts.IVGENY.getNumber();


       /* boolean run = true;
        while(run) {
            //init the bot
            try {
                WhatsAppBot.start();
                System.out.println("Bot started!");
            } catch (Exception e) {
                System.out.println("Bot failed! to start!\nerror : " + e.getMessage());
            }


            System.out.println("to send message to whatsapp write 'send'\nto stop the bot, write 'stop'");
            boolean stop = false;
            while (!stop) {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                switch (input) {
                    case "send":
                        System.out.println("enter your message!");
                        sendMess = scanner.nextLine();
                        try {
                            WhatsAppBot.sendMessage(ivgenyPhoneNum, sendMess);
                            System.out.println("message sent!");
                        } catch (Exception e) {
                            System.out.println("WhatsApp bot send message failed!");
                        }
                        break;
                    case "stop":
                        stop = true;
                        run = false;
                        try {
                            WhatsAppBot.stop();
                            System.out.println("bot stopped!");
                        } catch (Exception e) {
                            System.out.println("WhatsApp bot stop failed!");
                        }
                        break;
                    default:
                        System.out.println("invalid input");
                        break;
                }

            }
        }*/




      // WhatsAppBot.start();

      /* while (true) {
           try {
               TimeUnit.MILLISECONDS.sleep(2000);
           }catch (InterruptedException e) {}
           MessageReceiver.fetchAndSaveMessages();
       }*/









    }
}
