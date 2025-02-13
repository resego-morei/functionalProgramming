import React from 'react';

export const NotificationItem = ({ icon: Icon, title, time }) => {
  return (
    <div className="flex items-center gap-3 p-3 hover:bg-gray-50 rounded-lg">
      <Icon className="h-5 w-5 text-gray-500" />
      <div className="flex-1">
        <p className="text-sm font-medium">{title}</p>
        <p className="text-xs text-gray-500">{time}</p>
      </div>
    </div>
  );
};
