// src/components/layout/Dashboard.jsx
import React from 'react';
import { Card, CardHeader, CardTitle, CardContent } from '@/components/ui/card';
import { StatCard, NotificationItem } from '../common';
import { stats } from '../../data/stats';
import { notifications } from '../../data/notifications';

export const Dashboard = () => {
  return (
    <div className="p-6 max-w-6xl mx-auto">
      <h1 className="text-2xl font-bold mb-6">Dashboard</h1>
      
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4 mb-6">
        {stats.map((stat, index) => (
          <StatCard key={index} {...stat} />
        ))}
      </div>

      <Card className="w-full">
        <CardHeader>
          <CardTitle>Recent Notifications</CardTitle>
        </CardHeader>
        <CardContent>
          {notifications.map((notification, index) => (
            <NotificationItem key={index} {...notification} />
          ))}
        </CardContent>
      </Card>
    </div>
  );
};

