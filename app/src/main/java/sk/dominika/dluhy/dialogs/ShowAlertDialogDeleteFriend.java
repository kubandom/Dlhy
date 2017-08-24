package sk.dominika.dluhy.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import sk.dominika.dluhy.databases.MyFirebaseDatabaseHandler;
import sk.dominika.dluhy.notifications.MyAlarmManager;

public class ShowAlertDialogDeleteFriend {

    /**
     * Show alert dialog with a message in an activity asking whether user wants to delete item_friend
     * Dialog has two buttons- POSITIVE = item_friend and debts will be deleted, notifications will be synchronized
     *                         NEGATIVE = item_friend and debts won't be deleted
     * @param message
     * @param activity
     * @param id_friend of item_friend to be deleted
     */
    public static void showAlertDialog(String message, final Activity activity, final String id_friend) {
        android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(activity).create();
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "YES",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MyFirebaseDatabaseHandler.deleteFriendAndDebts(id_friend, activity.getBaseContext());
                    }
                });
        alertDialog.show();
    }
}